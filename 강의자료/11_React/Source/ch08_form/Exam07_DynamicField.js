import React, { useEffect, useState } from "react";

function Exam07() {
  const [formFields, setFormFields] = useState([{ name: "", value: "" }]);

  const handleAddFields = () => {
    const values = [...formFields, { name: "", value: "" }];
    setFormFields(values);
  };

  const handleRemoveFields = (index) => {
    if (formFields.length === 1) {
      alert("At least one form must remain");
      return;
    }
    const values = [...formFields].splice(index, 1);
    setFormFields(values);
  };

  const handleInputChange = (index, e) => {
    const values = [...formFields];

    if (e.target.name === "name") {
      values[index].name = e.target.value;
    } else {
      values[index].value = e.target.value;
    }
    setFormFields(values);
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log(formFields);
  };

  useEffect(() => {
    console.log("formFields changed:", formFields);
  }, [formFields]);

  return (
    <form onSubmit={handleSubmit} style={{ padding: "2%" }}>
      {formFields.map((field, index) => (
        <div key={index} style={{ marginBottom: 5 }}>
          <input
            type="text"
            placeholder="Field name"
            name="name"
            value={field.name}
            onChange={(e) => handleInputChange(index, e)}
            style={{ marginRight: 10 }}
          />

          <input
            type="text"
            placeholder="Field value"
            name="value"
            value={field.value}
            onChange={(e) => handleInputChange(index, e)}
            style={{ marginRight: 10 }}
          />

          <button type="button" onClick={() => handleRemoveFields(index)}>
            Remove
          </button>
        </div>
      ))}

      <button
        type="button"
        onClick={() => handleAddFields()}
        style={{ marginTop: 10, marginRight: 10 }}
      >
        Add Field
      </button>

      <button type="submit">Submit</button>
    </form>
  );
}

export default Exam07;
