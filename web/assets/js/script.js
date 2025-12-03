document.querySelectorAll(".p-card__btn").forEach((btn) => {
  btn.addEventListener("click", () => {
    alert("Đã thêm vào giỏ hàng!");
  });
});

const searchInput = document.querySelector(".search__input");
const suggestionsList = document.querySelector(".search__suggestions");

searchInput.addEventListener("input", () => {
  const query = searchInput.value.trim().toLowerCase();
  suggestionsList.innerHTML = "";

  if (!query) {
    suggestionsList.style.display = "none";
    return;
  }

  const matches = products.filter(p =>
    p.name.toLowerCase().includes(query)
  );

  if (matches.length === 0) {
    suggestionsList.style.display = "none";
    return;
  }

  matches.forEach(p => {
    const li = document.createElement("li");
    li.classList.add("search__suggestion-item");

    li.innerHTML = `
      <img src="${p.image}" alt="${p.name}" class="search__suggestion-img">
      <div class="search__suggestion-info">
        <span class="search__suggestion-name">${p.name}</span>
        <span class="search__suggestion-price">${p.price.toLocaleString()}₫</span>
      </div>
    `;

    li.addEventListener("click", () => {
      searchInput.value = p.name;
      suggestionsList.style.display = "none";
    });

    suggestionsList.appendChild(li);
  });

  suggestionsList.style.display = "block";
});

document.addEventListener("click", (e) => {
  if (!e.target.closest(".search")) {
    suggestionsList.style.display = "none";
  }
});
