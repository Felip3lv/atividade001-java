public class Atividade001 {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Uso: java Atividade001 \"seu texto aqui\"");
            return;
        }

        String texto = String.join(" ", args);

        String[] palavras = texto.trim().split("\\s+");
        int totalPalavras = palavras.length;

        String textoNormalizado = texto.toLowerCase()
                .replaceAll("[áàãâä]", "a")
                .replaceAll("[éèêë]", "e")
                .replaceAll("[íìîï]", "i")
                .replaceAll("[óòõôö]", "o")
                .replaceAll("[úùûü]", "u");

        int totalVogais = 0;
        for (char c : textoNormalizado.toCharArray()) {
            if ("aeiou".indexOf(c) >= 0) {
                totalVogais++;
            }
        }

        int palavrasImpares = 0;
        int palavrasPares = 0;

        for (String palavra : palavras) {
            String apenasLetras = palavra.replaceAll("[^a-zA-ZÀ-ú]", "");
            if (apenasLetras.isEmpty()) continue;

            if (apenasLetras.length() % 2 == 0) {
                palavrasPares++;
            } else {
                palavrasImpares++;
            }
        }

        System.out.println("=== Analise do Texto ===");
        System.out.println("Texto: " + texto);
        System.out.println("------------------------");
        System.out.println("Total de palavras : " + totalPalavras);
        System.out.println("Total de vogais   : " + totalVogais);
        System.out.println("------------------------");
        System.out.println("Palavras com numero de letras IMPAR : " + palavrasImpares);
        System.out.println("Palavras com numero de letras PAR   : " + palavrasPares);
    }
}