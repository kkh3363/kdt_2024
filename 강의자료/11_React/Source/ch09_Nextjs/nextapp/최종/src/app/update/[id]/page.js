"use client";

import { useParams, useRouter } from "next/navigation";
import { useEffect, useState } from "react";

export default function Update() {
  const params = useParams();
  const router = useRouter();
  const [title, setTitle] = useState("");
  const [body, setBody] = useState("");
  const id = params.id;

  async function refresh() {
    const resp = await fetch(
      `${process.env.NEXT_PUBLIC_API_SERVER}topics/${id}`
    );
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

          const resp = await fetch(
            `${process.env.NEXT_PUBLIC_API_SERVER}topics/${id}`,
            {
              method: "PATCH",
              header: {
                "Content-Type": "application/json",
              },
              body: JSON.stringify({ title, body }),
            }
          );
          const topic = await resp.json();
          console.log("topic", topic);
          //const routeString = "/read/" + topic.id;
          router.push(`/read/${topic.id}`);
          //router.push(routeString);

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
