import React, { useState } from "react";

const Footer = () => {
  const [clicks, setClicks] = useState(0);

  const handleClick = () => {
    setClicks(clicks +1);

  };

  return (
    <footer class="text-body-secondary py-5">
      <div class="container">
        <p class="float-end mb-1">
          <a href="#">Back to top</a>
        </p>
        <p class="mb-1">
          Album example is &copy; Bootstrap, but please download and customize
          it for yourself! 
        </p>
        <p class="mb-0">
          New to Bootstrap? <a href="/">Visit the homepage</a> or read our{" "}
          <a href="/docs/5.3/getting-started/introduction/">
            getting started guide Clicks={clicks}
          </a>
          .
        </p>

        <span
          className="col-md-4 d-flex align-items-center justify-content-center mb-3 mb-md-0 me-md-auto link-body-emphasis text-decoration-none"
          onClick={handleClick}
        >
          <img
            className="App-logo"
            height="20"
            src="dog.png"
            alt="dog"
          />
        </span>
      </div>
    </footer>
  );
};

export default Footer;
