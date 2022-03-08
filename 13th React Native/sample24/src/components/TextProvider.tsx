import React, { createContext } from "react";

export const TextContext = createContext({});

interface Props {
    children: JSX.Element
}

export default function TextProvider({children}:Props) {

    const text = "전달하는 값";

    return (
        <TextContext.Provider value={text}>
            {children}
        </TextContext.Provider>
    );
}