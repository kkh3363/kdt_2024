export default async function Read(props) {
  const id = props.params.id;
  const resp = await fetch(
    `${process.env.NEXT_PUBLIC_API_SERVER}topics/${id}`,
    {
      cache: "no-cache",
    }
  );
  const topic = await resp.json();
  return (
    <>
      <h2>{topic.title}</h2>
      {topic.body}
    </>
  );
}
