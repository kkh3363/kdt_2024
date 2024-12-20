"use client";
import Link from "next/link";
import { useParams, useRouter } from "next/navigation";

export function Control() {
  const router = useRouter();
  const params = useParams();
  const id = params.id;

  return (
    <ul>
      <li>
        <Link href="/create">Create</Link>
      </li>
      {id ? (
        <>
          <li>
            <Link href={"/update/" + id}>Update</Link>
          </li>
          <li>
            <button
              onClick={async (event) => {
                const resp = await fetch(
                  `${process.env.NEXT_PUBLIC_API_SERVER}topics/${id}`,
                  {
                    method: "DELETE",
                  }
                );
                await resp.json();
                router.push(`/`);
                router.refresh();
              }}
            >
              Delete
            </button>
          </li>
        </>
      ) : null}
    </ul>
  );
}
