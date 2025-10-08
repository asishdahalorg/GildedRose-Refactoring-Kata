UPDATERS = {}

def register_update_function(names: list) -> None:
  def wrapper(func):
      if names:
        for name in names:
          UPDATERS[name] = func
      return func
  return wrapper