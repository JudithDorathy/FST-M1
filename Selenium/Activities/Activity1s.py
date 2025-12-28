from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.chrome.service import Service
from webdriver_manager.chrome import ChromeDriverManager

# Setup Chrome driver
driver = webdriver.Chrome(service=Service(ChromeDriverManager().install()))

try:
    # Navigate to the URL
    driver.get("https://training-support.net/")

    # Print the title of the page
    print("Page title is: ", driver.title)

    # Find the "About Us" button on the page using ID and click it
    driver.find_element(By.LINK_TEXT, "About Us").click()

    # Print the title of the new page
    print("New page title is: ", driver.title)
except Exception as e:
    print(f"Error occurred: {e}")
finally:
    # Close the browser
    driver.quit()