import xmlrpc.client
from user import User

nome_usuario = input("Digite seu nome de usuário: ")
senha = input("Digite sua senha: ")

usuario = User(nome_usuario, senha)

user_data = {'nome_usuario': usuario.nome_usuario, 'senha': usuario.senha}

server = xmlrpc.client.ServerProxy("http://localhost:8000")

response = server.verify_access(user_data)
print(response)