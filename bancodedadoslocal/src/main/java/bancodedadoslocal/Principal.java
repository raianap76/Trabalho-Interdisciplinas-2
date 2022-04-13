package bancodedadoslocal;

public class Principal {
	
	public static void main(String[] args) {
		
		DAO dao = new DAO();
		
		dao.conectar();

		
		//Inserir um elemento na tabela
		Usuario usuario = new Usuario(21, "pablo", "pablo",'M');
		if(dao.inserirUsuario(usuario) == true) {
			System.out.println("Inser��o com sucesso -> " + usuario.toString());
		}
		
		//Mostrar usuários do sexo masculino		
		System.out.println("==== Mostrar usuarios do sexo masculino === ");
		Usuario[] usuarios = dao.getUsuariosMasculinos();
		for(int i = 0; i < usuarios.length; i++) {
			System.out.println(usuarios[i].toString());
		}

		//Atualizar usuário
		usuario.setSenha("nova senha");
		dao.atualizarUsuario(usuario);

		//Mostrar usuários do sexo masculino
		System.out.println("==== Mostrar usuarios === ");
		usuarios = dao.getUsuarios();
		for(int i = 0; i < usuarios.length; i++) {
			System.out.println(usuarios[i].toString());
		}
		
		//Excluir usuário
		dao.excluirUsuario(usuario.getCodigo());
		
		//Mostrar usuários
		usuarios = dao.getUsuarios();
		System.out.println("==== Mostrar usuarios === ");		
		for(int i = 0; i < usuarios.length; i++) {
			System.out.println(usuarios[i].toString());
		}
		
		dao.close();
	}
}