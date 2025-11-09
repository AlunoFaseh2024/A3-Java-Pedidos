const API_BASE = "http://localhost:8080/api";

// === CATEGORIAS ===
export async function listarCategorias() {
  const res = await fetch(`${API_BASE}/categorias`);
  if (!res.ok) throw new Error("Erro ao carregar categorias");
  return res.json();
}

export async function criarCategoria(categoria) {
  const res = await fetch(`${API_BASE}/categorias`, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(categoria)
  });
  if (!res.ok) throw new Error("Erro ao criar categoria");
  return res.json();
}

export async function atualizarCategoria(id, categoria) {
  const res = await fetch(`${API_BASE}/categorias/${id}`, {
    method: "PUT",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(categoria)
  });
  if (!res.ok) throw new Error("Erro ao atualizar categoria");
  return res.json();
}

export async function deletarCategoria(id) {
  const res = await fetch(`${API_BASE}/categorias/${id}`, {
    method: "DELETE"
  });
  if (!res.ok) throw new Error("Erro ao deletar categoria");
}

// === PRODUTOS ===
export async function listarProdutos() {
  const res = await fetch(`${API_BASE}/produtos`);
  if (!res.ok) throw new Error("Erro ao carregar produtos");
  return res.json();
}

export async function buscarProdutoPorId(id) {
  const res = await fetch(`${API_BASE}/produtos/${id}`);
  if (!res.ok) throw new Error("Produto não encontrado");
  return res.json();
}

export async function criarProduto(produto) {
  const res = await fetch(`${API_BASE}/produtos`, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(produto)
  });
  if (!res.ok) throw new Error("Erro ao criar produto");
  return res.json();
}

export async function atualizarProduto(id, produto) {
  const res = await fetch(`${API_BASE}/produtos/${id}`, {
    method: "PUT",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(produto)
  });
  if (!res.ok) throw new Error("Erro ao atualizar produto");
  return res.json();
}

export async function deletarProduto(id) {
  const res = await fetch(`${API_BASE}/produtos/${id}`, {
    method: "DELETE"
  });
  if (!res.ok) throw new Error("Erro ao deletar produto");
}

// === PEDIDOS ===
export async function listarPedidos() {
  const res = await fetch(`${API_BASE}/pedidos`);
  if (!res.ok) throw new Error("Erro ao carregar pedidos");
  return res.json();
}

export async function buscarPedidoPorId(id) {
  const res = await fetch(`${API_BASE}/pedidos/${id}`);
  if (!res.ok) throw new Error("Pedido não encontrado");
  return res.json();
}

export async function criarPedido(pedido) {
  const res = await fetch(`${API_BASE}/pedidos`, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(pedido)
  });
  if (!res.ok) throw new Error("Erro ao criar pedido");
  return res.json();
}

export async function atualizarStatusPedido(id, novoStatus) {
  const res = await fetch(`${API_BASE}/pedidos/${id}/status?status=${novoStatus}`, {
    method: "PUT"
  });
  if (!res.ok) throw new Error("Erro ao atualizar status");
  return res.json();
}

export async function deletarPedido(id) {
  const res = await fetch(`${API_BASE}/pedidos/${id}`, {
    method: "DELETE"
  });
  if (!res.ok) throw new Error("Erro ao deletar pedido");
}

// === CLIENTES ===
export async function listarClientes() {
  const res = await fetch(`${API_BASE}/clientes`);
  if (!res.ok) throw new Error("Erro ao carregar clientes");
  return res.json();
}

export async function criarCliente(cliente) {
  const res = await fetch(`${API_BASE}/clientes`, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(cliente)
  });
  if (!res.ok) throw new Error("Erro ao criar cliente");
  return res.json();
}

// === FUNCIONÁRIOS ===
export async function listarFuncionarios() {
  const res = await fetch(`${API_BASE}/funcionarios`);
  if (!res.ok) throw new Error("Erro ao carregar funcionários");
  return res.json();
}

export async function criarFuncionario(funcionario) {
  const res = await fetch(`${API_BASE}/funcionarios`, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(funcionario)
  });
  if (!res.ok) throw new Error("Erro ao criar funcionário");
  return res.json();
}

export async function deletarFuncionario(id) {
  const res = await fetch(`${API_BASE}/funcionarios/${id}`, {
    method: "DELETE"
  });
  if (!res.ok) throw new Error("Erro ao deletar funcionário");
}

export async function loginFuncionario(identificador, senha) {
  const res = await fetch(`${API_BASE}/funcionarios/login?identificador=${identificador}&senha=${senha}`, {
    method: "POST"
  });
  if (!res.ok) throw new Error("Credenciais inválidas");
  return res.json();
}