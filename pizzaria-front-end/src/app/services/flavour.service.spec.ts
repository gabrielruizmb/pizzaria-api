import { TestBed } from '@angular/core/testing';

import { FlavourService } from './flavour.service';

describe('FlavourService', () => {
  let service: FlavourService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FlavourService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
