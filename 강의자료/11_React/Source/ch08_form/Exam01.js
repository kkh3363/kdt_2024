import { useState } from "react";

export default function Login() {
  const [loginInput, setLoginInput] = useState({
    email: "",
    password: "",
  });

  function handleInputChange(field, event) {
    setLoginInput((prevState) => ({
      ...prevState,
      [field]: event.target.value,
    }));
  }

  function handleSubmit(event) {
    event.preventDefault();
    console.log(loginInput);
  }

  return (
    <form onSubmit={handleSubmit}>
      <div className="container">
        <div className="loginform">
          <h2>Login</h2>
          <div>
            <label forName="email">Email</label>
            <input
              id="email"
              type="email"
              onChange={(event) => handleInputChange("email", event)}
              value={loginInput.email}
            />
          </div>
          <div>
            <label forName="password">Password</label>
            <input
              id="password"
              type="password"
              onChange={(event) => handleInputChange("password", event)}
              value={loginInput.password}
            />
          </div>
          <p>
            <button type="submit">Submit</button>
          </p>
        </div>
      </div>
    </form>
  );
}
