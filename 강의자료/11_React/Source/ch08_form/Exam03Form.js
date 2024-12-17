import React from "react";

export default function Login() {
  function handleSubmit(event) {
    event.preventDefault();
    // e.target은 빨간줄 떴음..
    const formData = new FormData(event.currentTarget);
    console.log(formData.get("email"));
    const data = Object.fromEntries(formData);
    console.log("data", data);
  }

  return (
    <div className="container">
      <div className="loginform">
        <form onSubmit={handleSubmit}>
          <h2>Signup</h2>
          <label>Email</label>
          <input type="email" name="email" />
          <label>Password</label>
          <input type="password" name="password" />
          <label>Gender</label>
          <select name="gender">
            <option value="male">Male</option>
            <option value="femail">Female</option>
            <option value="other">Other</option>
          </select>
          <br />
          <label className="radio_label">Quantity</label>
          <input type="radio" name="quantity" value="1" /> 1
          <input type="radio" name="quantity" value="2" /> 2
          <input type="radio" name="quantity" value="3" /> 3
          <br />
          <label>Terms</label>
          <input type="checkbox" name="terms" value="Y" /> 
          <span>I agree to the Terms and Conditions</span>
          <p>
            <button type="submit">Register</button>
          </p>
        </form>
      </div>
    </div>
  );
}
