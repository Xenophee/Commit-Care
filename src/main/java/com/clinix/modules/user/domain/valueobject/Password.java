package com.clinix.modules.user.domain.valueobject;

//import org.mindrot.jbcrypt.BCrypt;

public record Password(String hash) {

    public Password {
        if (hash == null || hash.isEmpty()) {
            throw new IllegalArgumentException("Hash invalide");
        }
    }

    /*public static Password fromPlainText(String plainText) {
        if (plainText == null || plainText.length() < 8) {
            throw new IllegalArgumentException("Mot de passe trop court");
        }
        String hashed = BCrypt.hashpw(plainText, BCrypt.gensalt());
        return new Password(hashed);
    }

    public boolean verify(String plainText) {
        return BCrypt.checkpw(plainText, this.hash);
    }

    @Override
    public String toString() {
        return "****"; // ne jamais exposer le hash
    }*/
}

