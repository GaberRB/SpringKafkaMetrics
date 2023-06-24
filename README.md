# Aplicação de Demonstração de Consumo em Lote e Multithread com Kafka, Prometheus e Grafana

Esta é uma aplicação de demonstração desenvolvida em Java com o framework Spring, utilizando o Apache Kafka para processamento de mensagens em lote e multithread. Também são utilizados o Prometheus e o Grafana para monitoramento e visualização dos dados.

## Pré-requisitos

- Docker e Docker Compose instalados na máquina local.

## Configuração

1. Clone o repositório para a sua máquina local.

2. Navegue até o diretório raiz do projeto.

3. Abra o arquivo `docker-compose.yml` e verifique as configurações dos serviços. Certifique-se de que as portas estejam corretas e os volumes estejam configurados de acordo com a sua preferência.

4. No arquivo `docker-compose.yml`, a seção `services` define os serviços a serem executados, como o Zookeeper, Kafka, Kafdrop, Prometheus e Grafana. Verifique se todas as dependências estão corretamente configuradas.

5. A seção `volumes` define os volumes Docker para persistência de dados. Você pode ajustar os caminhos dos volumes de acordo com a sua preferência.

6. Após verificar e ajustar as configurações, salve o arquivo `docker-compose.yml`.

## Executando a Aplicação

1. Abra um terminal ou prompt de comando.

2. Navegue até o diretório raiz do projeto, onde se encontra o arquivo `docker-compose.yml`.

3. Execute o seguinte comando para iniciar os serviços definidos no arquivo `docker-compose.yml`:

Isso iniciará os contêineres Docker para o Zookeeper, Kafka, Kafdrop, Prometheus e Grafana. Os serviços serão executados em segundo plano (`-d`).

4. Aguarde até que todos os serviços estejam em execução. Verifique se não há erros no log de inicialização dos contêineres.

## Utilização

Após iniciar os serviços, você pode acessar os seguintes recursos:

- Kafdrop: Acesse o Kafdrop em http://localhost:9000 para visualizar e explorar os tópicos e mensagens do Kafka.

- Prometheus: Acesse o Prometheus em http://localhost:9090 para visualizar as métricas coletadas do Kafka.

- Grafana: Acesse o Grafana em http://localhost:3000 e faça login com as credenciais padrão (usuário: admin, senha: admin). Configure um novo painel para visualizar os dados e métricas coletadas pelo Prometheus.
- Adicione o DashBoard template do grafana
  - [DashBoard SpringMetrics Grafana](https://grafana.com/grafana/dashboards/14430-spring-boot-statistics-endpoint-metrics/)
- Adicione o datasource do prometheus
  ![image](https://github.com/GaberRB/SpringKafkaMetrics/assets/28874479/dbafe7a5-e892-40b1-90b7-75023811bfae)

- Configure as variaveis de ambiente da seguente forma:
  ![image](https://github.com/GaberRB/SpringKafkaMetrics/assets/28874479/e0cdfb8b-6b79-4c3b-99c2-c60d97c3a4e1)
 

## Recursos Adicionais

- [Documentação do Zookeeper](https://zookeeper.apache.org/doc/current/)
- [Documentação do Kafka](https://kafka.apache.org/documentation/)
- [Documentação do Kafdrop](https://github.com/obsidiandynamics/kafdrop)
- [Documentação do Prometheus](https://prometheus.io/docs/)
- [Documentação do Grafana](https://grafana.com/docs/)


## Notas

Certifique-se de que todas as dependências e configurações estejam corretas antes de executar a aplicação. Caso encontre algum problema ou dificuldade, consulte a documentação oficial dos serviços utilizados ou verifique as configurações e logs dos contêineres Docker.


