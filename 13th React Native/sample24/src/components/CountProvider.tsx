import React, { createContext, useState } from "react";

export const CountContext = createContext({});

interface Props {
    children: JSX.Element
}

export const CountProvider = ({children}:Props) => {

    const [count, setCount] = useState(0);


    return (
        <CountContext.Provider value={[count, setCount]}>
            {children}
        </CountContext.Provider>
    );
}