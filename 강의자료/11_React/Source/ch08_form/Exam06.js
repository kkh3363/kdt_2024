import { Formik, Field, ErrorMessage, Form } from "formik";

export default function Login() {
  return (
    <Formik
      initialValues={{ email: "", password: "" }}
      validate={(values) => {
        const errors = {};
        if (!values.email) {
          errors.email = "Required";
        } else if (
          !/^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,}$/i.test(values.email)
        ) {
          errors.email = "Invalid email address";
        }
        return errors;
      }}
      onSubmit={(values, { setSubmitting }) => {
        setTimeout(() => {
          console.log(values);
          setSubmitting(false);
        }, 100);
      }}
    >
      {({ isSubmitting }) => (
        <div className="container">
          <div className="loginform">
            <Form>
              <h2>Login</h2>
              <div className="control">
                <label>Email</label>
                <Field type="email" name="email" />
                <ErrorMessage name="email" component="div" />
              </div>
              <div className="control">
                <label>Password</label>
                <Field type="password" name="password" />
                <ErrorMessage name="password" component="div" />
              </div>
              <p>
                <button type="submit" disabled={isSubmitting}>
                  Submit
                </button>
              </p>
            </Form>
          </div>
        </div>
      )}
    </Formik>
  );
}
