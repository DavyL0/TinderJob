import com.dlopes.tinderjob.model.User;
import com.dlopes.tinderjob.model.Vaga;

import java.util.List;
import java.util.stream.Collectors;

public class VagaDTO {
    private Long id;
    private String nome;
    private String descricao;
    private List<String> users;

    public VagaDTO(Vaga vaga) {
        this.id = vaga.getId();
        this.nome = vaga.getNome();
        this.descricao = vaga.getDescription();
        this.users = vaga.getUsers().stream()
                .map(User::getUsername)
                .collect(Collectors.toList());
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<String> getUsers() {
        return users;
    }

    public void setUsers(List<String> users) {
        this.users = users;
    }
}
