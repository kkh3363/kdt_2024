const Button = ({ onClick, children }) => {
    return <button onClick={onClick}>{children}</button>;
  };
const PlayButton = ({ musicName }) => {
    const handlePlayClick = () => {
      alert(`${musicName}을 재생합니다.`);
    };
  
    return <Button onClick={handlePlayClick}>▶ Play "{musicName}"</Button>;
};
const StopButton =() => {
    return (
        <Button onClick={()=>
            alert("재생을 중지합니다")
        }>Stop</Button>
    )
}
const ControlPanel = () =>{
    return (
        <>
            <PlayButton musicName="TRUST" />
            <StopButton />
        </>
    )
}
export default ControlPanel;
