package br.fatec;

import java.sql.ResultSet;
import java.util.ArrayList;

public class JogadorMinecraftDAO {


	public ArrayList<JogadorMinecraft> pegar() throws Exception{
    var jogadoresMinecraft = new ArrayList<JogadorMinecraft>();
    var sql = "SELECT * FROM tb_personagem";
    try(
        var conexao = ConnectionFactory.obterConexao();
        var ps = conexao.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
    ){
        while(rs.next()){
            var codigo = rs.getInt("codigo");
            var nome = rs.getString("nome");
            var probConstruir = rs.getFloat("prob_construir");
            var probColetarMadeira = rs.getFloat("prob_coletar_madeira");
            var probMineirar = rs.getFloat("prob_minerar");
            var vitorias = rs.getInt("vitorias");
            var derrotas = rs.getInt("derrotas");
            var personagens = new JogadorMinecraft(codigo, nome, probConstruir, probColetarMadeira, probMineirar, vitorias, derrotas);
            jogadoresMinecraft.add(personagens);
        }
        return jogadoresMinecraft;
    }   
}
}

