document.addEventListener("DOMContentLoaded", async function () {
  const dashboardButton = document.querySelector("#dashboard__button");
  const customersButton = document.querySelector("#customers__button");
  console.log("DOM content loaded");
  const carsButton = document.querySelector("#cars__button");
  const dashboard = document.querySelector("#dashboard");
  const tabsContainer = document.querySelector(".sidebar__links");
  const tabs = document.querySelectorAll(".sidebar__link");
  const content = document.querySelectorAll(".content__main");
  const addContent = document.querySelectorAll(".add__content");
  const loader = document.getElementById("loader");
  const customersTable = document.querySelector(".customers__table");
  const addTabsContainer = document.querySelector(".add__tabs--container");
  const addTabs = document.querySelectorAll(".add__tab");

  function formatDate(date) {
    const day = String(date.getDate()).padStart(2, "0");
    const month = String(date.getMonth() + 1).padStart(2, "0"); // Month is zero-based
    const year = date.getFullYear();

    return `${day}/${month}/${year}`;
  }

  const today = new Date(); // Get today's date
  document.getElementById("date").innerText = formatDate(today);

  const fetchData = async function (url) {
    try {
      const res = await fetch(url);
      return await res.json();
    } catch (error) {}
  };

  const customersData = await fetchData(
    `http://localhost:8080/api/v1/customers`
  );
  document.querySelector("#total__customers").innerText = customersData.length;

  document.querySelector("#added__customers").innerText =
    customersData.length - 16 >= 0 ? customersData.length - 16 : "0";
  const carsData = await fetchData(`http://localhost:8082/api/v1/car`);
  document.querySelector("#total__cars").innerText = carsData.length;
  document.querySelector("#added__cars").innerText =
    carsData.length - 28 >= 0 ? carsData.length - 28 : "0";

  tabsContainer.addEventListener("click", async function (e) {
    const clicked = e.target.closest(".sidebar__link");
    console.log(clicked);

    if (!clicked) return;
    loader.style.display = "block";

    setTimeout(() => {
      document
        .querySelector(`.content__${clicked.dataset.tab}`)
        .classList.add("content__active");
      loader.style.display = "none";

      if (clicked.dataset.tab === "customers") {
        const customersEdit = document.querySelectorAll(".customers__edit");

        customersEdit.forEach((link) => {
          link.addEventListener("click", function (e) {
            e.preventDefault();
            const row = e.target.closest("tr");
            const customerId = row.querySelector("td:first-child").innerText;
            const firstName = row.querySelector("td:nth-child(2)").innerText;
            console.log(firstName);
            const lastName = row.querySelector("td:nth-child(3)").innerText;
            const licenseNumber =
              row.querySelector("td:nth-child(4)").innerText;

            customersButton.classList.remove("sidebar__item--active");

            document
              .querySelector("#add__button")
              .classList.add("sidebar__item--active");

            document
              .querySelector(".content__customers")
              .classList.remove("content__active");

            document
              .querySelector(".content__add")
              .classList.add("content__active");

            document.querySelector("#customerId").value = customerId;
            document.querySelector("#firstName").value = firstName;
            document.querySelector("#lastName").value = lastName;
            document.querySelector("#licenseNumber").value = licenseNumber;
          });
        });
      }

      if (clicked.dataset.tab === "cars") {
        const carsEdit = document.querySelectorAll(".cars__edit");

        carsEdit.forEach((link) => {
          link.addEventListener("click", function (e) {
            e.preventDefault();
            const row = e.target.closest("tr");
            const carId = row.querySelector("td:first-child").innerText;

            const carBrand = row.querySelector("td:nth-child(2)").innerText;
            const carModel = row.querySelector("td:nth-child(3)").innerText;
            const carColor = row.querySelector("td:nth-child(4)").innerText;
            const carDailyRate = row.querySelector("td:nth-child(5)").innerText;
            console.log(carId, carBrand, carModel, carDailyRate, carColor);

            // Handle sidebar button activation
            document
              .querySelector("#cars__button")
              .classList.remove("sidebar__item--active");

            document
              .querySelector("#add__button")
              .classList.add("sidebar__item--active");

            // Switch to the "Add" tab
            document
              .querySelector(".content__cars")
              .classList.remove("content__active");
            document
              .querySelector(".content__add")
              .classList.add("content__active");

            // Activate the "Cars" content within the "Add" tab
            document
              .querySelector(".add__content--car")
              .classList.add("add__content--active");

            // Now, specifically switch to the "Cars" section within the "Add" tab
            addTabs.forEach((tab) => {
              tab.classList.remove("add__tab--active");
              if (tab.dataset.tab === "car") {
                tab.classList.add("add__tab--active");
              }
            });

            // Populate form fields with the data
            document.querySelector("#carId").value = carId;
            document.querySelector("#carBrand").value = carBrand;
            document.querySelector("#carModel").value = carModel;
            document.querySelector("#carColor").value = carColor;
            document.querySelector("#dailyRate").value = carDailyRate;
          });
        });
      }
    }, 150);

    tabs.forEach((t) => t.classList.remove("sidebar__item--active"));
    content.forEach((c) => c.classList.remove("content__active"));
    clicked.classList.add("sidebar__item--active");

    if (clicked.dataset.tab === "customers") {
      const data = await fetchData("http://localhost:8080/api/v1/customers");
      const customersBody = document.querySelector(".customers__body");
      customersBody.innerHTML = "";

      data.forEach((customer) => {
        const row = document.createElement("tr");
        row.classList.add("customers__brow");
        row.dataset.customerId = customer.customer_id;

        const markup = `
          <td class="customers__bdata">${customer.customer_id}</td>
          <td class="customers__bdata">${customer.first_Name}</td>
          <td class="customers__bdata">${customer.last_Name}</td>
          <td class="customers__bdata">${customer.license_Number}</td>
          <td class="customers__bdata">
            <a href="#" class="customers__edit">Edit</a> / 
            <a href="#add" class="customers__delete">Delete</a>
          </td>
        `;

        row.innerHTML = markup;
        customersBody.appendChild(row);

        const deleteLink = row.querySelector(".customers__delete");
        deleteLink.addEventListener("click", function (e) {
          e.preventDefault();
          const customerId = customer.customer_id;

          deleteCustomer(customerId, row); // Call function to delete the customer
        });
      });
    }

    if (clicked.dataset.tab === "cars") {
      const data = await fetchData("http://localhost:8082/api/v1/car");
      const carsBody = document.querySelector(".cars__body");
      carsBody.innerHTML = "";

      data.forEach((car) => {
        const row = document.createElement("tr");
        row.classList.add("cars__brow");
        row.dataset.carId = car.id;

        const markup = `
        <td class="cars__bdata">${car.id}</td>
        <td class="cars__bdata">${car.brand}</td>
        <td class="cars__bdata">${car.model}</td>
        <td class="cars__bdata">${car.color}</td>
        <td class="cars__bdata">${car.dailyRate}</td>
        <td class="cars__bdata">
            <a href="#" class="cars__edit">Edit</a> / 
            <a href="#" class="cars__delete">Delete</a>
          </td>
        `;

        row.innerHTML = markup;
        carsBody.appendChild(row);

        const deleteLink = row.querySelector(".cars__delete");
        deleteLink.addEventListener("click", function (e) {
          e.preventDefault();
          const carId = car.id;

          deleteCar(carId, row); // Call function to delete the car
        });
      });
    }

    if (clicked.dataset.tab === "rentals") {
      const data = await fetchData("http://localhost:8084/api/v1/rental");
      const carsBody = document.querySelector(".rentals__body");
      carsBody.innerHTML = "";

      data.forEach((rental) => {
        const row = document.createElement("tr");
        row.classList.add("cars__brow");

        const markup = `
        <td class="cars__bdata">${rental.customer.first_Name}</td>
        <td class="cars__bdata">${rental.customer.last_Name}</td>
        <td class="cars__bdata">${rental.car1.brand}</td>
        <td class="cars__bdata">${rental.car1.model}</td>
        <td class="cars__bdata">${rental.rental_Date}</td>
        <td class="cars__bdata">${rental.return_Date}</td>
        <td class="cars__bdata">${rental.full_Price}</td>
        
        `;

        row.innerHTML = markup;
        carsBody.appendChild(row);
      });
    }
  });

  addTabsContainer.addEventListener("click", function (e) {
    const clicked = e.target.closest(".add__tab");
    console.log(clicked);

    if (!clicked) return;

    addTabs.forEach((t) => t.classList.remove("add__tab--active"));
    addContent.forEach((c) => c.classList.remove("add__content--active"));
    clicked.classList.add("add__tab--active");
    document
      .querySelector(`.add__content--${clicked.dataset.tab}`)
      .classList.add("add__content--active");
  });

  //////////// CRUD Customer
  document
    .getElementById("addCustomer")
    .addEventListener("submit", function (e) {
      e.preventDefault();
      const customerId = document.getElementById("customerId").value;

      if (customerId) {
        const firstName = document.getElementById("firstName").value;
        const lastName = document.getElementById("lastName").value;
        const licenseNumber = document.getElementById("licenseNumber").value;

        const updatedCustomer = {
          first_Name: firstName,
          last_Name: lastName,
          license_Number: licenseNumber,
        };

        const buildUpdateURL = (customerId, updatedCustomerData) => {
          const { first_Name, last_Name, license_Number } = updatedCustomerData;

          // Encode the license number to handle spaces or special characters
          const encodedLicenseNumber = encodeURIComponent(license_Number);

          // Construct the URL with the updated data
          const url = `http://localhost:8080/api/v1/customers/${customerId}?First_name=${first_Name}&Last_name=${last_Name}&License_number=${encodedLicenseNumber}`;

          return url;
        };

        const url = buildUpdateURL(customerId, updatedCustomer);
        updateCustomer(url, updatedCustomer);
      } else {
        const firstName = document.getElementById("firstName").value;
        const lastName = document.getElementById("lastName").value;
        const licenseNumber = document.getElementById("licenseNumber").value;

        const newCustomer = {
          first_Name: firstName,
          last_Name: lastName,
          license_Number: licenseNumber,
        };

        addNewCustomer(newCustomer);
      }

      document.getElementById("customerId").value = "";
      document.getElementById("firstName").value = "";
      document.getElementById("lastName").value = "";
      document.getElementById("licenseNumber").value = "";
    });

  function addNewCustomer(newCustomer) {
    fetch("http://localhost:8080/api/v1/customers", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(newCustomer),
    })
      .then((response) => {
        if (!response.ok) {
          throw new Error(
            `Network response was not ok - status: ${response.status}`
          );
        }
        // Handle successful response, if needed
        console.log(newCustomer);
        const markup = `<div class="add__message">
        <svg class="add__message--icon">
          <use xlink:href="img/sprite.svg#icon-notification" />
        </svg>
        <h3 class="add__message--header">
          Customer Added / Updated Successfully
        </h3>
      </div>`;

        document.querySelector("#addButton").classList.add("add__processing");
        document.querySelector("#addButton").innerHTML = markup;

        setTimeout(() => {
          document
            .querySelector("#addButton")
            .classList.remove("add__processing");
          document.querySelector("#addButton").innerText =
            "Add/Update Customer";
        }, 3000);
      })
      .catch((error) => {
        console.error("There was a problem adding the new customer:", error);
      });
  }

  const updateCustomer = async (url, updatedCustomerData) => {
    try {
      const response = await fetch(url, {
        method: "PUT",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(updatedCustomerData),
      });

      console.log("URL:", url); // Log the URL
      console.log("Data:", JSON.stringify(updatedCustomerData)); // Log the data sent

      if (!response.ok) {
        throw new Error(
          `Network response was not ok - status: ${response.status}`
        );
      }

      console.log("Customer updated successfully");
      // Optionally, handle any UI updates or other logic after successful update
      const markup = `<div class="add__message">
        <svg class="add__message--icon">
          <use xlink:href="img/sprite.svg#icon-notification" />
        </svg>
        <h3 class="add__message--header">
          Customer Added / Updated Successfully
        </h3>
      </div>`;

      document.querySelector("#addButton").classList.add("add__processing");
      document.querySelector("#addButton").innerHTML = markup;

      setTimeout(() => {
        document
          .querySelector("#addButton")
          .classList.remove("add__processing");
        document.querySelector("#addButton").innerText = "Add/Update Customer";
      }, 3000);
    } catch (error) {
      console.error("There was a problem updating the customer:", error);
    }
  };

  // const row = e.target.closest("tr");
  // const deleteLink = row.querySelector(".customers__delete");
  // deleteLink.addEventListener("click", function (e) {
  //   e.preventDefault();
  //   const customerId = row.querySelector("td:first-child").innerText;

  //   deleteCustomer(customerId); // Call function to delete the customer
  // });

  // customersBody.appendChild(row);

  function deleteCustomer(customerId, row) {
    fetch(`http://localhost:8080/api/v1/customers/${customerId}`, {
      method: "DELETE",
    })
      .then((response) => {
        if (!response.ok) {
          throw new Error(
            `Network response was not ok - status: ${response.status}`
          );
        }
        // Handle successful response
        console.log("Customer deleted successfully");

        // Find the parent row and remove it from the DOM
        row.remove();
      })
      .catch((error) => {
        console.error("There was a problem deleting the customer:", error);
      });
  }

  /////////// CRUD Car
  const carForm = document.getElementById("addCar");
  carForm.addEventListener("submit", function (e) {
    e.preventDefault();
    console.log("Form submitted!");

    const carId = document.getElementById("carId").value;

    if (carId) {
      const carBrand = document.getElementById("carBrand").value;
      const carModel = document.getElementById("carModel").value;
      const carColor = document.getElementById("carColor").value;
      const carDailyRate = document.getElementById("dailyRate").value;

      const updatedCar = {
        brand: carBrand,
        color: carColor,
        dailyRate: carDailyRate,
        model: carModel,
      };

      const buildUpdateURL = (carId, updatedCar) => {
        const { brand, color, dailyRate, model } = updatedCar;

        // Construct the URL with the updated data
        const url = `http://localhost:8082/api/v1/car/${carId}?brand=${brand}&color=${color}&dailyRate=${dailyRate}&model=${model}`;

        return url;
      };

      const url = buildUpdateURL(carId, updatedCar);
      console.log(url);
      updateCar(url, updatedCar);
    } else {
      const carBrand = document.getElementById("carBrand").value;
      const carModel = document.getElementById("carModel").value;
      const carColor = document.getElementById("carColor").value;
      const carDailyRate = document.getElementById("dailyRate").value;

      const newCar = {
        brand: carBrand,
        model: carModel,
        color: carColor,
        dailyRate: carDailyRate,
      };

      addNewCar(newCar);
    }

    document.getElementById("carBrand").value = "";
    document.getElementById("carModel").value = "";
    document.getElementById("carColor").value = "";
    document.getElementById("dailyRate").value = "";
  });

  function addNewCar(newCar) {
    fetch("http://localhost:8082/api/v1/car", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(newCar),
    })
      .then((response) => {
        if (!response.ok) {
          throw new Error(
            `Network response was not ok - status: ${response.status}`
          );
        }
        // Handle successful response, if needed
        console.log(newCar);
        const markup = `<div class="add__message">
        <svg class="add__message--icon">
          <use xlink:href="img/sprite.svg#icon-notification" />
        </svg>
        <h3 class="add__message--header">
          Car Added / Updated Successfully
        </h3>
      </div>`;

        document
          .querySelector("#addButtonCar")
          .classList.add("add__processing");
        document.querySelector("#addButtonCar").innerHTML = markup;

        setTimeout(() => {
          document
            .querySelector("#addButtonCar")
            .classList.remove("add__processing");
          document.querySelector("#addButtonCar").innerText = "Add/Update Car";
        }, 3000);
      })
      .catch((error) => {
        console.error("There was a problem adding the new customer:", error);
      });
  }

  function deleteCar(carId, row) {
    fetch(`http://localhost:8082/api/v1/car/${carId}`, {
      method: "DELETE",
    })
      .then((response) => {
        if (!response.ok) {
          throw new Error(
            `Network response was not ok - status: ${response.status}`
          );
        }
        // Handle successful response
        console.log("Car deleted successfully");

        row.style.backgroundColor = "red";
        row.innerHTML = `<h2 style={width:100%}>car with id: ${carId} will be deleted</h2>`;

        // Find the parent row and remove it from the DOM
        row;
        setTimeout(() => {
          row.remove();
        }, 3000);
      })
      .catch((error) => {
        console.error("There was a problem deleting the customer:", error);
      });
  }

  const updateCar = async (url, updatedCar) => {
    try {
      const response = await fetch(url, {
        method: "PUT",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(updatedCar),
      });

      console.log("URL:", url); // Log the URL
      console.log("Data:", JSON.stringify(updatedCar)); // Log the data sent

      if (!response.ok) {
        throw new Error(
          `Network response was not ok - status: ${response.status}`
        );
      }

      console.log("Customer updated successfully");

      const markup = `<div class="add__message">
        <svg class="add__message--icon">
          <use xlink:href="img/sprite.svg#icon-notification" />
        </svg>
        <h3 class="add__message--header">
          Car Added / Updated Successfully
        </h3>
      </div>`;

      document.querySelector("#addButtonCar").classList.add("add__processing");
      document.querySelector("#addButtonCar").innerHTML = markup;

      setTimeout(() => {
        document
          .querySelector("#addButtonCar")
          .classList.remove("add__processing");
        document.querySelector("#addButtonCar").innerText =
          "Add/Update Customer";
      }, 3000);
    } catch (error) {
      console.error("There was a problem updating the customer:", error);
    }
  };
});
