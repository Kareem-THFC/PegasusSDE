const dashboardButton = document.querySelector("#dashboard__button");
const customersButton = document.querySelector("#customers__button");
const dashboard = document.querySelector("#dashboard");
const tabsContainer = document.querySelector(".sidebar__links");
const tabs = document.querySelectorAll(".sidebar__link");
const content = document.querySelectorAll(".content__main");
const loader = document.getElementById("loader");

// dashboard.addEventListener("click", function () {
//   console.log("button");
// });

// customersButton.addEventListener("click", () => {
//   document.querySelector("#customers").classList.remove("hidden");
//   dashboard.classList.add("hidden");
// });

tabsContainer.addEventListener("click", function (e) {
  const clicked = e.target.closest(".sidebar__link");
  console.log(clicked);

  if (!clicked) return;
  loader.style.display = "block";

  tabs.forEach((t) => t.classList.remove("sidebar__item--active"));
  content.forEach((c) => c.classList.remove("content__active"));
  clicked.classList.add("sidebar__item--active");

  setTimeout(() => {
    document
      .querySelector(`.content__${clicked.dataset.tab}`)
      .classList.add("content__active");
    loader.style.display = "none";
  }, 150);
});
