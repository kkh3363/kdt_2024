import Image from "next/image";
import executeQuery from "./_lib/db";

export default async function Home() {
  const sql = "select * from nextdb.member";
  const data = await executeQuery(sql, "");
  const getData = JSON.parse(JSON.stringify(data));
  return (
    <>
      <h2>Welcome</h2>
      Hello, WEB
      <p>
        {getData.map((data, i) => {
          return (
            <div key={i}>
              <p>
                {data.id} {data.name}
              </p>
            </div>
          );
        })}
      </p>
    </>
  );
}
