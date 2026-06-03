const navToggle = document.querySelector(".nav-toggle");
const navLinks = document.querySelector(".nav-links");
const newsletterForms = document.querySelectorAll(".newsletter-form, .footer-form");

if (navToggle && navLinks) {
    navToggle.addEventListener("click", () => {
        const isOpen = navLinks.classList.toggle("open");
        navToggle.setAttribute("aria-expanded", String(isOpen));
    });

    navLinks.querySelectorAll("a").forEach((link) => {
        link.addEventListener("click", () => {
            navLinks.classList.remove("open");
            navToggle.setAttribute("aria-expanded", "false");
        });
    });
}

newsletterForms.forEach((form) => {
    form.addEventListener("submit", (event) => {
        const emailInput = form.querySelector("input[type='email']");

        if (!emailInput || emailInput.checkValidity()) {
            return;
        }

        event.preventDefault();
        emailInput.reportValidity();
    });
});
