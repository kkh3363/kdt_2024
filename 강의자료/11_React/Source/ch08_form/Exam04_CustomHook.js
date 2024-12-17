import { useInput } from "./useInput";

export default function Login() {
  const {
    value: emailValue,
    handleInputChange: handleEmailChange,
    hasError: emailHasError,
  } = useInput("", (value) => value.includes("@"));

  const {
    value: passwordValue,
    handleInputChange: handlePasswordChange,
    hasError: passwordHasError,
  } = useInput("", (value) => value.length >= 4);

  function handleSubmit(event) {
    event.preventDefault();
    console.log(emailValue, passwordValue);
  }

  return (
    <div className="container">
      <div className="loginform">
        <form onSubmit={handleSubmit}>
          <h2>Login</h2>
          <label>Email</label>
          <input type="email" onChange={handleEmailChange} value={emailValue} />
          {emailHasError && (
            <span className="invalid_msg">Please enter a valid email</span>
          )}

          <label>Password</label>
          <input
            type="password"
            onChange={handlePasswordChange}
            value={passwordValue}
            error={passwordHasError && "Please enter a valid password"}
          />
          <p>
            <button type="submit">Submit</button>
          </p>
        </form>
      </div>
    </div>
  );
}
