document.addEventListener("DOMContentLoaded", () => {
  document.querySelectorAll(".validated-form").forEach((form) => {
    form.addEventListener("submit", (event) => {
      if (!form.checkValidity()) {
        event.preventDefault();
        alert("Please fill all required fields correctly.");
      }
    });
  });
});
