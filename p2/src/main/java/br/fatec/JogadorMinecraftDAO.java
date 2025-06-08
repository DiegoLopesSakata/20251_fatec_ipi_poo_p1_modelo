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

    public void vitoriaDerrota(JogadorMinecraft jogador, int vitoria, int derrota) throws Exception{
		var sql = "UPDATE tb_personagem SET vitorias=?, derrotas=? WHERE codigo=?";

		try(
			var conexao = 
					ConnectionFactory.obterConexao();
			var ps = conexao.prepareStatement(sql);
		){
            ps.setInt(1, jogador.getVitorias() + vitoria);
			ps.setInt(2, jogador.getDerrotas() + derrota);
			ps.setInt(3, jogador.getCodigo());
			ps.execute();
		}
	}

    public void probabilidade(JogadorMinecraft jogador, double probConstruir, double probColetarMadeira, double probMinerar) throws Exception{
		var sql = "UPDATE tb_personagem SET prob_construir=?, prob_coletar_madeira=?, prob_minerar=? WHERE codigo=?";

		try(
			var conexao = 
					ConnectionFactory.obterConexao();
			var ps = conexao.prepareStatement(sql);
		){
            ps.setDouble(1, probConstruir);
			ps.setDouble(2, probColetarMadeira);
			ps.setDouble(3, probMinerar);
			ps.setInt(4, jogador.getCodigo());
			ps.execute();
		}
	}
}