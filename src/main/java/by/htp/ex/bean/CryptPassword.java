package by.htp.ex.bean;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;
import java.util.Objects;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class CryptPassword {
	
	 StringBuilder hashPassword;
	 SecretKeyFactory factory;
	 KeySpec keySpec;
	 byte[] hash;
	 String password;
	 String hashPasswordSTR;
	 
	 
	 
	 public CryptPassword(String password) {
		 System.out.println("CryptPassword");
		 this.password=password;
		 byte[] salt = {9,3,4,5,7,5,4};

	     keySpec = new PBEKeySpec(password.toCharArray(),salt,65536,128);
	     try {
			factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
		} catch (NoSuchAlgorithmException e) {
			
			e.printStackTrace();
		}
	      try {
			hash = factory.generateSecret(keySpec).getEncoded();
			 StringBuilder hashPassword = new StringBuilder();
		     for(byte b : hash){
		         hashPassword.append(String.format("%x", b));
		        hashPasswordSTR = hashPassword.toString();
		     }
		} catch (InvalidKeySpecException e) {
			
			e.printStackTrace();
		}

	    
	 }



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(hash);
		result = prime * result + Objects.hash(factory, hashPassword, keySpec, password);
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CryptPassword other = (CryptPassword) obj;
		return Objects.equals(factory, other.factory) && Arrays.equals(hash, other.hash)
				&& Objects.equals(hashPassword, other.hashPassword) && Objects.equals(keySpec, other.keySpec)
				&& Objects.equals(password, other.password);
	}



	@Override
	public String toString() {
		return 	hashPasswordSTR  ;
	}
	

	

	
	
	

		
	}


