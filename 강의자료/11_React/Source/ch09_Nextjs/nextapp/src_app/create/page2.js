"use client";
import { useRouter } from "next/navigation";

export default function Create() {
  const router = useRouter();

  return (
    <form
      onSubmit={async (event) => {
        event.preventDefault();
        const title = event.target.title.value;
        const body = event.target.body.value;
        const resp = await fetch("http://localhost:9999/topics/", {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
          },
          body: JSON.stringify({ title, body }),
        });
        const topic = await resp.json();
        console.log("file: create ~ topic", topic);
        router.push(`/read/${topic.id}`);
        router.refresh();
      }}
    >
      <h2>Create</h2>
      <p>
        <input type="text" name="title" placeholder="제목" />
      </p>
      <p>
        <input type="text" name="body" placeholder="내용" />
      </p>
      <p>
        <input type="submit" value="create" />
      </p>
    </form>
  );
}
