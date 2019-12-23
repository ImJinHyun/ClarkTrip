package com.clark.web;

import java.io.UnsupportedEncodingException;

import org.bouncycastle.jcajce.provider.digest.Keccak.DigestKeccak;

public class CrytoSHA3 {
	public String crytoSHA3(String key, int hash) {
		DigestKeccak md = new DigestKeccak(hash);
		
		try {
			md.update(key.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		byte[] digest = md.digest();
		
		return org.bouncycastle.util.encoders.Hex.toHexString(digest);
		
	}
}
