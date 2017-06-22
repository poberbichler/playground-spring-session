import requests
from bs4 import BeautifulSoup


class HomeRequests():
    def __init__(self, url):
        print(f"requesting cookie for url: [{url}]")
        self.url = url
        self.cookie = requests.get(url).cookies

    def _find_text_by_id(self, id):
        request = requests.get(self.url, cookies=self.cookie)
        return BeautifulSoup(request.text, "html.parser").find(id=id).text

    def extract_session_id(self):
        return self._find_text_by_id("sessionId")

    def extract_port(self):
        return self._find_text_by_id("currentUUID")

    def extract_initial_port(self):
        return self._find_text_by_id("initialUUID")
