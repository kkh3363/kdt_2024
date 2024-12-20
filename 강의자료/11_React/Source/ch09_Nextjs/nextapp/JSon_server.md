### npm json server
- npx json-server --port 9999 --watch db.json
- http://localhost:9999/topics
- React를 이용한 방법 ( client side )
```
"use client";
import { useEffect, useState } from "react";
import "./globals.css";
import Link from "next/link";

export default function RootLayout({ children }) {
  const [topics, setTopics] = useState([]);
  useEffect(() => {
    fetch("http://localhost:9999/topics")
      .then((resp) => resp.json())
      .then((result) => {
        setTopics(result);
      });
  }, []);
  console.log("topics", topics);
  return (
    <html lang="en">
      <body>
        <h1><Link href="/">WEB</Link></h1>
        <ol>
          <li><Link href="/read/1">html</Link></li>
          <li><Link href="/read/2">css</Link></li>
        </ol>
        {children}
        <ul>
          <li><Link href="/create">create</Link></li>
          <li><Link href="/update/1">update</Link></li>
          <li><button>delete</button></li>
        </ul>
      </body>
    </html>
  );
}
```
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
- 오류가 난다면 json-server 재설치
```
npm install json-server --save --legacy-peer-deps
```


- 
