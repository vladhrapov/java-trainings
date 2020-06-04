$(document).ready(function () {
  $("#search").on("keydown", $.debounce(800, searchBy));
  $("#item-list").on("click", remove);
  $("#save").on("click", save);
  $("#search").on("mousedown", ($event) => {
    if (!$event.target.value) {
      $("#item-list").empty();
      $("#item-list").append($(`<div>No Content, please search!</div>`));
    }
  });
  $("#search").on("click", ($event) => {
    if (!$event.target.value) {
      $("#item-list").empty();
      $("#item-list").append($(`<div>No Content, please search!</div>`));
    }
  });
});

function save($event) {
  const keyValue = {};

  $("#add > input[type='text']").each((index, item) => {
    keyValue[item.id] = item.value;
  });

  const finding = {
    description: keyValue.description,
    keywords: getKeywordsFromString(keyValue.keywords),
    contactInfo: {
      name: keyValue.name,
      address: keyValue.address,
      phoneNumber: keyValue.phoneNumber,
    },
  };

  fetch("findings", {
    method: "POST",
    mode: "cors",
    cache: "no-cache",
    credentials: "same-origin",
    headers: {
      "Content-Type": "application/json",
    },
    referrerPolicy: "no-referrer",
    body: JSON.stringify(finding),
  })
    .then((response) => response.json())
    .then((payload) => {
      console.log("Successfully saved: ", payload);
      $("#add > input[type='text']").each((index, item) => {
        item.value = "";
      });
    });
}

function remove($event) {
  const { id } = $event.target.dataset;

  fetch(`/findings/${id}`, {
    method: "DELETE",
  })
    .then((response) => response.json())
    .then((payload) => {
      $($event.target).parent("li").remove();
      console.log("Deleted: ", payload);
    });
}

function searchBy($event) {
  const searchString = getKeywordsFromString($event.target.value).join(",");

  fetch(`/findings/search?q=${searchString}`)
    .then((response) => {
      return response.json();
    })
    .then((payload) => {
      const itemList = $("#item-list");

      $("#item-list").empty();

      payload.data.forEach(({ id, description, keywords, contactInfo }) =>
        $("#item-list").append(
          $(`<li class="list-group-item">
              <div>Description: ${description}</div>
              <div>Keywords: ${keywords.join(", ")}</div>
              <div>Contact Info: ${contactInfo.name}, ${
            contactInfo.phoneNumber
          }, ${contactInfo.address}</div>
            <button id="remove" data-id="${id}" type="button" class="btn btn-danger">Remove</button>
            </li>`)
        )
      );
    });
}

function getKeywordsFromString(keywordsString) {
  return keywordsString
    .split(",")
    .map((keyword) => keyword.trim().toLowerCase())
    .filter((keyword) => !!keyword);
}
