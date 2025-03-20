function hideLoadingScreen() {
  const loadingScreen = document.getElementById('loading-screen');
  const body = document.body;

  loadingScreen.style.opacity = '1';
  loadingScreen.style.transition = 'opacity 1s ease-out';

  setTimeout(() => {
    loadingScreen.style.opacity = '0';

    body.style.transition = 'background-image 1s ease-out';
    body.style.backgroundImage = 'none';

    setTimeout(() => {
      loadingScreen.style.display = 'none';
    }, 1000);
  }, 10);
}

function createParticles() {
  const particlesContainer = document.getElementById('particles');
  const particleCount = 12;

  const isMobile = window.innerWidth <= 768;
  const actualCount = isMobile ? 8 : particleCount;

  for (let i = 0; i < actualCount; i++) {
    const particle = document.createElement('div');
    particle.classList.add('particle');

    const size = Math.random() * 3 + 3;
    particle.style.width = `${size}px`;
    particle.style.height = `${size}px`;

    const xPos = Math.random() * 100;
    const yPos = Math.random() * 100;
    particle.style.left = `${xPos}%`;
    particle.style.top = `${yPos}%`;

    particle.style.opacity = Math.random() * 0.6 + 0.2;

    const duration = Math.random() * 10 + 10;
    const delay = Math.random() * 5;
    particle.style.animation = `float ${duration}s linear infinite ${delay}s`;

    particlesContainer.appendChild(particle);
  }
}

window.addEventListener('load', createParticles);