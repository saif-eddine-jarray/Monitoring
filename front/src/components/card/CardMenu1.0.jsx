import React, { useEffect, useState } from "react";
import Dropdown from "components/dropdown";

function CardMenu1(props) {
  const { transparent } = props;
  const [open, setOpen] = React.useState(false);
  const [status,setStatus]=useState("All status");
  useEffect(()=>{console.log(status);
    props.sendData(status);},[status]);
  const handleClickGenerated = () => {
    if (status=="Generated"){
      setStatus("All status");
    }else{
      setStatus("Generated");
    }
  };
  const handleClickDelivered = () => {
    if (status=="Delivered"){
      setStatus("All status");
    }else{setStatus("Delivered");}
  };
  const handleClickArchived = () => {
    if (status=="Archived"){
      setStatus("All status");
    }else{setStatus("Archived");}
  };
  const handleClickError = () => {
    setStatus("Error");
  };
  return (
    <Dropdown
      button={
        <button
          onClick={() => setOpen(!open)}
          open={open}
          style={{ fontSize: '100%', color: '#899499' }}
          className={`flex items-center text-xl hover:cursor-pointer ${
            transparent
              ? "bg-none text-white hover:bg-none active:bg-none"
              : "bg-lightPrimary p-2 text-brand-500 hover:bg-gray-100 dark:bg-navy-700 dark:text-white dark:hover:bg-white/20 dark:active:bg-white/10"
          } linear justify-center rounded-lg font-bold transition duration-200`}
        >
          {status}
        </button>
      }
      animation={"origin-top-right transition-all duration-300 ease-in-out"}
      classNames={`${transparent ? "top-8" : "top-11"} right-0 w-max`}
      children={
        <div className="z-50 w-max rounded-xl bg-white py-3 px-4 text-sm shadow-xl shadow-shadow-500 dark:!bg-navy-700 dark:shadow-none">
          <button onClick={handleClickGenerated}>
          <p className={`${!(status==="Generated") ? "hover:text-black flex cursor-pointer items-center gap-2 text-gray-600 hover:font-medium" : "hover:text-black flex cursor-pointer items-center gap-2 text-black-600 hover:font-medium"}`}>
            <span>
              <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" strokeWidth={1.5} stroke="currentColor" className="w-6 h-6">
                <path strokeLinecap="round" strokeLinejoin="round" d="M7.5 7.5h-.75A2.25 2.25 0 0 0 4.5 9.75v7.5a2.25 2.25 0 0 0 2.25 2.25h7.5a2.25 2.25 0 0 0 2.25-2.25v-7.5a2.25 2.25 0 0 0-2.25-2.25h-.75m0-3-3-3m0 0-3 3m3-3v11.25m6-2.25h.75a2.25 2.25 0 0 1 2.25 2.25v7.5a2.25 2.25 0 0 1-2.25 2.25h-7.5a2.25 2.25 0 0 1-2.25-2.25v-.75" />
              </svg>
            </span>
            Generated
          </p>
          </button>
          <button onClick={handleClickDelivered}>
          <p className={`${!(status==="Delivered") ? "hover:text-black flex cursor-pointer items-center gap-2 text-gray-600 hover:font-medium" : "hover:text-black flex cursor-pointer items-center gap-2 text-black-600 hover:font-medium"}`}>
            <span>
            < svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" strokeWidth={1.5} stroke="currentColor" className="w-6 h-6">
                <path strokeLinecap="round" strokeLinejoin="round" d="M13.5 6H5.25A2.25 2.25 0 0 0 3 8.25v10.5A2.25 2.25 0 0 0 5.25 21h10.5A2.25 2.25 0 0 0 18 18.75V10.5m-10.5 6L21 3m0 0h-5.25M21 3v5.25" />
              </svg>
            </span>
           Delivered
          </p>
          </button>
          <button onClick={handleClickArchived}>
          <p className={`${!(status==="Archived") ? "hover:text-black flex cursor-pointer items-center gap-2 text-gray-600 hover:font-medium" : "hover:text-black flex cursor-pointer items-center gap-2 text-black-600 hover:font-medium"}`}>
              <span>
                <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" strokeWidth={1.5} stroke="currentColor" className="w-6 h-6">
                  <path strokeLinecap="round" strokeLinejoin="round" d="m20.25 7.5-.625 10.632a2.25 2.25 0 0 1-2.247 2.118H6.622a2.25 2.25 0 0 1-2.247-2.118L3.75 7.5M10 11.25h4M3.375 7.5h17.25c.621 0 1.125-.504 1.125-1.125v-1.5c0-.621-.504-1.125-1.125-1.125H3.375c-.621 0-1.125.504-1.125 1.125v1.5c0 .621.504 1.125 1.125 1.125Z" />
                </svg>
            </span>
            Archived
          </p>
          </button>
          <button onClick={handleClickError}>
          <p className={`${!(status==="Error") ? "hover:text-black flex cursor-pointer items-center gap-2 text-gray-600 hover:font-medium" : "hover:text-black flex cursor-pointer items-center gap-2 text-black-600 hover:font-medium"}`}>
              <span>
                <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" strokeWidth={1.5} stroke="currentColor" className="w-6 h-6">
                  <path strokeLinecap="round" strokeLinejoin="round" d="M12 9v3.75m-9.303 3.376c-.866 1.5.217 3.374 1.948 3.374h14.71c1.73 0 2.813-1.874 1.948-3.374L13.949 3.378c-.866-1.5-3.032-1.5-3.898 0L2.697 16.126ZM12 15.75h.007v.008H12v-.008Z" />
                </svg>

            </span>
            Error
          </p>
          </button>
        </div>
      }
    />
  );
}

export default CardMenu1;
