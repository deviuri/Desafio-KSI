
function nextPage() {
    const url = new URL(window.location.href);
    const searchParams = url.searchParams;
    let pageNumber = searchParams.get('page');
    let titulo = searchParams.get('titulo');
    pageNumber++;

    window.location = `${window.location.origin}${window.location.pathname}?titulo=${titulo}&page=${pageNumber}`;
}
function backPage(){
    const url = new URL(window.location.href);
    const searchParams = url.searchParams;
    let pageNumber = searchParams.get('page');
    let titulo = searchParams.get('titulo');
    pageNumber -= 1;

    window.location = `${window.location.origin}${window.location.pathname}?titulo=${titulo}&page=${pageNumber}`;
}
function backPageFavo(){
    const url = new URL(window.location.href);
    const searchParams = url.searchParams;
    let pageNumber = searchParams.get('page');
    pageNumber -= 1;

    window.location = `${window.location.origin}${window.location.pathname}?page=${pageNumber}`;
}
function nextPageFavo() {
    const url = new URL(window.location.href);
    const searchParams = url.searchParams;
    let pageNumber = searchParams.get('page');
    pageNumber++;

    window.location = `${window.location.origin}${window.location.pathname}?page=${pageNumber}`;
}