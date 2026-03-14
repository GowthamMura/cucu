function randomColors(n) {
  const palette = ['#1f77b4','#ff7f0e','#2ca02c','#d62728','#9467bd','#8c564b','#e377c2','#7f7f7f','#bcbd22','#17becf'];
  return Array.from({ length: n }, (_, i) => palette[i % palette.length]);
}

function createBarChart(id, labels, values, label) {
  const el = document.getElementById(id);
  if (!el) return;
  new Chart(el, {
    type: 'bar',
    data: { labels, datasets: [{ label, data: values, backgroundColor: randomColors(values.length) }] },
    options: { responsive: true, plugins: { legend: { display: false } } }
  });
}

function createLineChart(id, labels, values, label) {
  const el = document.getElementById(id);
  if (!el) return;
  new Chart(el, {
    type: 'line',
    data: { labels, datasets: [{ label, data: values, borderColor: '#1f6feb', fill: false, tension: 0.2 }] },
    options: { responsive: true }
  });
}

function createPieChart(id, labels, values) {
  const el = document.getElementById(id);
  if (!el) return;
  new Chart(el, {
    type: 'doughnut',
    data: { labels, datasets: [{ data: values, backgroundColor: randomColors(values.length) }] },
    options: { responsive: true }
  });
}
