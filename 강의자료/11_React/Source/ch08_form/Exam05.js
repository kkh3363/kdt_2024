import { useForm } from "react-hook-form";

export default function Login() {
  const {
    register,
    handleSubmit,
    formState: { errors },
  } = useForm();

  return (
    <div className="container">
      <div className="loginform">
        <form onSubmit={handleSubmit((data) => console.log(data))}>
          <h2>Login</h2>
          <label>Email</label>
          <input type="email" {...register("email", { required: true })} />
          {errors.email && (
            <span className="invalid_msg">Email is required.</span>
          )}

          <label>Password</label>
          <input
            type="password"
            {...register("password", { required: true })}
          />
          {errors.password && (
            <span className="invalid_msg">Password is required.</span>
          )}
          <p>
            <button type="submit">Submit</button>
          </p>
        </form>
      </div>
    </div>
  );
}
