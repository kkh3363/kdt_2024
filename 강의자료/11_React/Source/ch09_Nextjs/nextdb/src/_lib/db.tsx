import { createPool } from "mysql2";
import { loadEnvConfig } from "@next/env";
const pool = createPool({
  host: process.env.DB_HOST,
  user: process.env.DB_USER,
  password: process.env.DB_PASS,
  database: process.env.DB_DATABASE,
  port: 3306,
});
pool.getConnection((err, conn) => {
  if (err) console.log("Error connecting to db...");
  else console.log("Connected to db...!");
  conn.release();
});
const executeQuery = (query, arrParams) => {
  return new Promise((resolve, reject) => {
    try {
      pool.query(query, arrParams, (err, data) => {
        if (err) {
          console.log("Error in executing the query");
          reject(err);
        }
        console.log("------db.jsx------");
        //console.log(data)
        resolve(data);
      });
    } catch (err) {
      reject(err);
    }
  });
};
export default executeQuery;

