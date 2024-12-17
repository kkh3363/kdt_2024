export default function Login() {
    return (
      <form  >
      <div className="container">
        <div className="loginform">
          <h2>Login</h2>
          <div>
            <label forName="email">Email</label>
            <input
              id="email"
              type="email"}
            />
          </div>
          <div>
            <label forName="password">Password</label>
            <input
              id="password"
              type="password" }
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
  
