import React, { useState } from "react";
import Dropdown from "components/dropdown";

function CardMenu(props) {
  const { transparent } = props;
  const [open, setOpen] = React.useState(false);
  let [center,setCenter]=useState("All centers");
  let[policy,setPolicy]=useState(true);
  let[billing,setBilling]=useState(true);
  let[claim,setclaim]=useState(true);
  
  const handleClickPolicy = () => {
    setPolicy(!policy);
    if(!policy){
      setCenter("All centers")
      props.sendData("All centers");
    }else{
      setclaim(true);
      setBilling(true);
      setCenter("Policy Center");
      props.sendData("policyCenter");
  
    };
    };
  const handleClickClaim = () => {
    setclaim(!claim);
    if(!claim){setCenter("All centers")
    props.sendData("All centers");
    }else{
      setBilling(true);
      setPolicy(true);
      setCenter("Claim Center");
      props.sendData("claimCenter");
    }
   
  };
  const handleClickBilling = () => {
    setBilling(!billing);
    if(!billing){
      setCenter("All centers");
      props.sendData("All centers");
    }else{
      setclaim(true);
      setPolicy(true);
      setCenter("Billing Center");
      props.sendData("BillingCenter");
    }
    
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
          {center}
        </button>
      }
      animation={"origin-top-right transition-all duration-300 ease-in-out"}
      classNames={`${transparent ? "top-8" : "top-11"} right-0 w-max`}
      children={
        <div className="z-50 w-max rounded-xl bg-white py-3 px-4 text-sm shadow-xl shadow-shadow-500 dark:!bg-navy-700 dark:shadow-none">
          <button onClick={handleClickPolicy}>
          
          <p className={`${policy ? "hover:text-black flex cursor-pointer items-center gap-2 text-gray-600 hover:font-medium" : "hover:text-black flex cursor-pointer items-center gap-2 text-black-600 hover:font-medium"}`}>
            <span>
              <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" strokeWidth={1.5} stroke="currentColor" className="w-6 h-6">
                <path strokeLinecap="round" strokeLinejoin="round" d="M21.75 17.25v-.228a4.5 4.5 0 0 0-.12-1.03l-2.268-9.64a3.375 3.375 0 0 0-3.285-2.602H7.923a3.375 3.375 0 0 0-3.285 2.602l-2.268 9.64a4.5 4.5 0 0 0-.12 1.03v.228m19.5 0a3 3 0 0 1-3 3H5.25a3 3 0 0 1-3-3m19.5 0a3 3 0 0 0-3-3H5.25a3 3 0 0 0-3 3m16.5 0h.008v.008h-.008v-.008Zm-3 0h.008v.008h-.008v-.008Z" />
              </svg>
            </span>
            Policy Center
          </p>
          </button>
          <button onClick={handleClickClaim}>
          <p className={`${claim ? "hover:text-black flex cursor-pointer items-center gap-2 text-gray-600 hover:font-medium" : "hover:text-black flex cursor-pointer items-center gap-2 text-black-600 hover:font-medium"}`}>
            <span>
            <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" strokeWidth={1.5} stroke="currentColor" className="w-6 h-6">
              <path strokeLinecap="round" strokeLinejoin="round" d="M21.75 17.25v-.228a4.5 4.5 0 0 0-.12-1.03l-2.268-9.64a3.375 3.375 0 0 0-3.285-2.602H7.923a3.375 3.375 0 0 0-3.285 2.602l-2.268 9.64a4.5 4.5 0 0 0-.12 1.03v.228m19.5 0a3 3 0 0 1-3 3H5.25a3 3 0 0 1-3-3m19.5 0a3 3 0 0 0-3-3H5.25a3 3 0 0 0-3 3m16.5 0h.008v.008h-.008v-.008Zm-3 0h.008v.008h-.008v-.008Z" />
            </svg>

            </span>
            Claim Center
          </p>
          </button>
          <button onClick={handleClickBilling}>
          <p className={`${billing ? "hover:text-black flex cursor-pointer items-center gap-2 text-gray-600 hover:font-medium" : "hover:text-black flex cursor-pointer items-center gap-2 text-black-600 hover:font-medium"}`}>
            <span>
              <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" strokeWidth={1.5} stroke="currentColor" className="w-6 h-6">
                <path strokeLinecap="round" strokeLinejoin="round" d="M21.75 17.25v-.228a4.5 4.5 0 0 0-.12-1.03l-2.268-9.64a3.375 3.375 0 0 0-3.285-2.602H7.923a3.375 3.375 0 0 0-3.285 2.602l-2.268 9.64a4.5 4.5 0 0 0-.12 1.03v.228m19.5 0a3 3 0 0 1-3 3H5.25a3 3 0 0 1-3-3m19.5 0a3 3 0 0 0-3-3H5.25a3 3 0 0 0-3 3m16.5 0h.008v.008h-.008v-.008Zm-3 0h.008v.008h-.008v-.008Z" />
              </svg>
            </span>
            Billing Center
          </p>
          </button>
        </div>
      }
    />
  );
}

export default CardMenu;
