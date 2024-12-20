"use client";

import Link from "next/link";
import { useParams } from "next/navigation";

export function Control() {
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
        </>
      ) : null}
    </ul>
  );
}
