import random
import pickle
import os

# generate dataset
def generate_random_array(n):
    return [random.randint(1, 2**14) for _ in range(n)]
def generate_sorted_array(n):
    return [i for i in range(1, n+1)]
def generate_reversed_sorted_array(n):
    return [i for i in range(n+1, 1, -1)]

# SAVE DATA into pickle
def save_data(filename: str, size: int, types: str) -> None:
    with open(filename, 'wb') as f:
        lst = None
        if types == "random": lst = generate_random_array(size)
        elif types == "sorted": lst = generate_sorted_array(size)
        else: lst = generate_reversed_sorted_array(size)
        pickle.dump(lst, f)

# LOAD DATA
def load_data(file_name: str) -> list:
    with open (file_name, 'rb') as f:
        lst = pickle.load(f)
        return lst