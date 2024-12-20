### npm json server
- npx json-server --port 9999 --watch db.json
- 글목록
```
export default async function RootLayout({ children }) {
  const resp = await fetch("http://localhost:9999/topics");
  const topics = await resp.json();
  console.log("topics", topics);
```

- 저장하기
```
const resp = await fetch("http://localhost:9999/topics", {
    method: "POST",
    body: JSON.stringify({ id: 3, title: "js", body: "js is ..." }),
    headers: {
      "content-type": "application/json",
    },
  });
  const topics = await resp.json();
  console.log("topics", topics);
```

- 글 읽기
```
const resp = await fetch('http://localhost:9999/topics/1')
const result = await resp.json();
console.log(result);
```

- 
