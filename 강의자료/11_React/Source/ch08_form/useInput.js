import { useState } from "react";

// 기본값 (defaultValue), 검증 함수(validationFn)
export function useInput(defaultValue, validationFn) {
  const [value, setValue] = useState(defaultValue);
  const valueIsValid = validationFn(value);

  function handleInputChange(event) {
    setValue(event.target.value);
  }

  return {
    value,
    handleInputChange, // onChange 함수
    hasError: !valueIsValid,
  };
}
