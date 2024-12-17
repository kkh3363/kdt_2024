import { useRef } from "react";

export default function Login() {
  const emailRef = useRef();
  const passwordRef = useRef();

  function handleSubmit(event) {
    event.preventDefault();
    console.log("email: " + emailRef.current.value);
    console.log("password: " + passwordRef.current.value);
  }

  return (
    <form onSubmit={handleSubmit}>
      <div className="container">
        <div className="loginform">
          <h2>Login</h2>
          <div>
            <label forName="email">Email</label>
            <input id="email" type="email" ref={emailRef} />
          </div>
          <div>
            <label forName="password">Password</label>
            <input id="password" type="password" ref={passwordRef} />
          </div>
          <p>
            <button type="submit">Submit</button>
          </p>
        </div>
      </div>
    </form>
  );
}
