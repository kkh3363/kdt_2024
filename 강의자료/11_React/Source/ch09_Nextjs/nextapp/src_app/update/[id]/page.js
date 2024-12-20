"use client";

import { useRouter } from "next/router";
import { useEffect, useState } from "react";

export default function Update(props) {
  const router = useRouter();
  const [title, setTitle] = useState("");
  const [body, setBody] = useState("");
  const id = props.params.id;

  async function refresh() {
    const resp = await fetch(`http://localhost:9999/topics/${id}`);
    const topic = await resp.json();
    setTitle(topic.title);
    setBody(topic.body);
  }

  useEffect(() => {
    refresh();
  }, []);
  return (
    <>
      <form
        onSubmit={async (event) => {
          event.preventDefault();
          const title = event.target.title.value;
          const body = event.target.body.value;
          const resp = await fetch(`http://localhost:9999/topics/${id}`, {
            method :'PATCH',
            header : {
              'Content-Type': 'application/json'
            },
            body : JSON.stringify({title, body})
          });
          const topic = resp.json();
          router.push(`/read/${topic.id}`);
          router.refresh();
        }}
      >
        <h2>Update</h2>
        <p>
          <input
            type="text"
            name="title"
            placeholder="제목"
            value={title}
            onChange={(e) => setTitle(e.target.value)}
          />
        </p>
        <p>
          <textarea
            name="body"
            placeholder="내용"
            value={body}
            onChange={(e) => setBody(e.target.value)}
          ></textarea>
        </p>
        <p>
          <input type="submit" value="Update" />
        </p>
      </form>
    </>
  );
}
