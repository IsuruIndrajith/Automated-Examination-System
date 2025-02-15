// Import the functions you need from the SDKs you need
import { initializeApp } from "firebase/app";
import { getAuth, GoogleAuthProvider, FacebookAuthProvider, signInWithPopup } from "firebase/auth";
// TODO: Add SDKs for Firebase products that you want to use
// https://firebase.google.com/docs/web/setup#available-libraries

// Your web app's Firebase configuration
const firebaseConfig = {
  apiKey: "AIzaSyCAEfbuKyqG-itb0BuWPCxVs4HCHFpWxMU",
  authDomain: "automated-examination-system.firebaseapp.com",
  projectId: "automated-examination-system",
  storageBucket: "automated-examination-system.firebasestorage.app",
  messagingSenderId: "988116360475",
  appId: "1:988116360475:web:bc2f03004a3468ae1807be"
};

const app = initializeApp(firebaseConfig);
const auth = getAuth(app);
const googleProvider = new GoogleAuthProvider();
const facebookProvider = new FacebookAuthProvider();

const signInWithGoogle = () => signInWithPopup(auth, googleProvider);
const signInWithFacebook = () => signInWithPopup(auth, facebookProvider);

export { auth, signInWithGoogle, signInWithFacebook };