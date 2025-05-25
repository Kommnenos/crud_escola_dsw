package br.ufscar.dc.dsw.controller;

import br.ufscar.dc.dsw.dao.AlunoDAO;
import br.ufscar.dc.dsw.dao.ClasseDAO;
import br.ufscar.dc.dsw.domain.Aluno;
import br.ufscar.dc.dsw.domain.Classe;
import java.io.IOException;
import java.io.Serial;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "AlunoController", urlPatterns = {"/aluno"})
public class AlunoController extends HttpServlet{

    @Serial
    private static final long serialVersionUID = 1L;
    private AlunoDAO dao;

    @Override
    public void init() throws ServletException{
        dao = new AlunoDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException{
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException{
        String action = request.getPathInfo();
        if (action == null){
            action = "";
        }

        try{
            switch (action){
                case "/cadastro":
                    apresentaFormCadastro(request, response);
                    break;
                case "/insercao":
                    insere(request, response);
                    break;
                case "/remocao":
                    remove(request, response);
                    break;
                case "/edicao":
                    apresentaFormEdicao(request, response);
                    break;
                case "/atualizacao":
                    atualize(request, response);
                    break;
                default:
                    lista(request, response);
                    break;

            }
        } catch(RuntimeException | IOException | ServletException e){
            throw new ServletException(e);
        }
    }

    private void lista(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        List<Aluno> listaAlunos = dao.getAll();
        request.setAttribute("listaAlunos", listaAlunos);
        request.setAttribute("contextPath", request.getContextPath().replace("/", ""));
        RequestDispatcher dispatcher = request.getRequestDispatcher("/aluno/lista.jsp");
        dispatcher.forward(request, response);
    }

    private Map<Integer, String> getClasses(){
        Map<Integer, String> editoras = new HashMap<>();
        for(Classe classe: new ClasseDAO().getAll()){
            editoras.put(classe.getId(), classe.getNome());
        }
        return editoras;
    }

    private void apresentaFormCadastro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setAttribute("classes", getClasses());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/aluno/cadastro.jsp");
        dispatcher.forward(request, response);
    }

    private void apresentaFormEdicao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int id = Integer.parseInt(request.getParameter("id"));
        Aluno aluno = dao.getById(id);
        request.setAttribute("aluno", aluno);
        request.setAttribute("classes", getClasses());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/aluno/cadastro.jsp");
        dispatcher.forward(request, response);
    }

    private void insere(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setCharacterEncoding("UTF-8");

        String nome = request.getParameter("nome");
        String sobrenome = request.getParameter("sobrenome");
        boolean pcd = Boolean.parseBoolean(request.getParameter("pcd"));
        short ano_nasc = Short.parseShort(request.getParameter("ano_nasc"));
        int classe_id = Integer.parseInt(request.getParameter("classe_id"));
        boolean cursando = Boolean.parseBoolean(request.getParameter("cursando"));

        Classe classe = new ClasseDAO().getById(classe_id);
        Aluno aluno = new Aluno(nome, sobrenome, pcd, ano_nasc, classe, cursando);
        dao.insert(aluno);
        response.sendRedirect("lista");
    }

    private void atualize(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setCharacterEncoding("UTF-8");

        int id = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("nome");
        String sobrenome = request.getParameter("sobrenome");
        boolean pcd = Boolean.parseBoolean(request.getParameter("pcd"));
        short ano_nasc = Short.parseShort(request.getParameter("ano_nasc"));
        int classe_id = Integer.parseInt(request.getParameter("classe_id"));
        boolean cursando = Boolean.parseBoolean(request.getParameter("cursando"));

        Classe classe = new ClasseDAO().getById(classe_id);
        Aluno aluno = new Aluno(id, nome, sobrenome, pcd, ano_nasc, classe, cursando);
        dao.update(aluno);
        response.sendRedirect("lista");
    }

    private void remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int id = Integer.parseInt(request.getParameter("id"));

        Aluno aluno = new Aluno(id);
        dao.delete(aluno);
        response.sendRedirect("lista");
    }
}
