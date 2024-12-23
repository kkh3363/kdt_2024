import Image from "next/image";
import executeQuery from "./_lib/db.tsx";
export default async function Home() {
  const sql = "select * from jspdb.tblmember";
  const data = await executeQuery(sql, "");
  const getdata = JSON.parse(JSON.stringify(data));
  console.log(getdata);
  return (
    <>
      <h2>Welcome</h2>
      Hello, WEB
      <p>
        {getdata.map((data, i) => {
          return (
            <div>
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

